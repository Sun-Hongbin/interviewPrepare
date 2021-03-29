package bjtu_prepare.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

/**
 *
 * 服务器，监听在6666端口 客户端发abc，返回 hello abc
 *
 * @Title
 * @Description
 * @Author SuperBin
 * @Date 2020年9月1日
 */
public class Server {

	public static void main(String[] args) throws IOException {

		RequestHandler requestHandler = new RequestHandler();

		// 资源需要被close，放在try中close
		try (ServerSocket serverSocket = new ServerSocket(6666)) {

			System.out.println("监听在" + serverSocket.getLocalSocketAddress());

			// 用于避免关闭服务器
			while (true) {
				// 接收连接
				Socket clientSocket = serverSocket.accept();
				SocketAddress address = clientSocket.getRemoteSocketAddress();
				System.out.println("Incomming connection from " + address);

				// 接收数据(用scanner帮助我们去读)，同样此处资源需要被close
				new ClientHandler(clientSocket, requestHandler).run();

			}

		}

	}

}
