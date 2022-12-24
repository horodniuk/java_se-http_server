package lecture16_http_interface.config;

/**
 * Этот компонент отвечает за рабочий поток соеденения который
 * будет обрабатывать соеденения от пользователя в отдельном потоке
 */
public interface HttpClientSocketHandler extends Runnable {

}
