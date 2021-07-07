package cc;

import java.io.Serializable;
import java.util.function.Consumer;

public class Server extends serverConnect{
	
	private int port;

	public Server(int port, Consumer<Serializable> onReceiveCallback) {
		super(onReceiveCallback);
		this.port = port;
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean isServer() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected String getIP() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected int getPort() {
		// TODO Auto-generated method stub
		return port;
	}
	
	

}
