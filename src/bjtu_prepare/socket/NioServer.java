package bjtu_prepare.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * NIO是个什么东西？其实就是JAVA new IO，取不出名字，就叫了这玩意儿
 * @Title
 * @Description
 * @Author SuperBin
 * @Date 2020年9月2日
 */
public class NioServer {

	public static void main(String[] args) throws IOException  {

		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

		// 在异步IO里，所有的操作都是不会block（阻塞）的
		serverSocketChannel.configureBlocking(false);

/*		// 如果有客户在等待连接，会返回一个clientChannel出来
		// 如果没有，会返回null
		SocketChannel clientChannel = serverSocketChannel.accept();*/

		serverSocketChannel.bind(new InetSocketAddress(8888));
		System.out.println("监听在" + serverSocketChannel.getLocalAddress());


		Selector selector = Selector.open();

		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

		ByteBuffer buffer = ByteBuffer.allocate(1024);

		RequestHandler requestHandler = new RequestHandler();

		while (true) {
			// Selects a set of keys whose corresponding channels are ready for I/O operations.
			int selected = selector.select();

			if (selected == 0) {
				continue;
			}

			Set<SelectionKey> selectedKeys = selector.selectedKeys();

			Iterator<SelectionKey> keyIter = selectedKeys.iterator();

			while (keyIter.hasNext()) {

				SelectionKey key = keyIter.next();

				if (key.isAcceptable()) {

					ServerSocketChannel channel = (ServerSocketChannel) key.channel();

					SocketChannel clientChannel = channel.accept();
					System.out.println("Incomming connection from " + clientChannel.getLocalAddress());

					clientChannel.configureBlocking(false);
					clientChannel.register(selector, SelectionKey.OP_READ);
				}

				if (key.isReadable()) {

					SocketChannel channel = (SocketChannel) key.channel();

					channel.read(buffer);

					String request = new String(buffer.array()).trim();

					buffer.clear();
					System.out.println(
							String.format("Request from %s: %s", channel.getLocalAddress(), request));

					String response = requestHandler.handle(request);

					channel.write(ByteBuffer.wrap(response.getBytes()));
				}


				keyIter.remove();

			}

		}

	}

}
