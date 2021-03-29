package bjtu_prepare.socket;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Title
 * @Description
 * @Author SuperBin
 * @Date 2020年9月2日
 */
public class ClientHandler implements Runnable{

	// TODO 为什么要加final
	private final Socket clientSocket;

	private final RequestHandler requestHandler;

	public ClientHandler(Socket clientSocket, RequestHandler requestHandler) {
		super();
		this.clientSocket = clientSocket;
		this.requestHandler = requestHandler;
	}

	@Override
	public void run(){
		try (Scanner input = new Scanner(clientSocket.getInputStream())) {

			while (true) {
				String request = input.nextLine();

				// 关闭连接
				if ("quit".equals(request)) {
					break;
				}

				System.out.println(
						String.format("Request from %s: %S", clientSocket.getRemoteSocketAddress(), request));

				String response = requestHandler.handle(request);
				clientSocket.getOutputStream().write(response.getBytes());
			}
		} catch (IOException e) {
			System.out.println("Caughtq exception: " + e);
			throw new RuntimeException(e);
		}

	}



}
