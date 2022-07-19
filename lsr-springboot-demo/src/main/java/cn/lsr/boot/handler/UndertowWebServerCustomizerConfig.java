package cn.lsr.boot.handler;

import io.undertow.server.HandlerWrapper;
import io.undertow.server.HttpHandler;
import io.undertow.server.handlers.DisallowedMethodsHandler;
import io.undertow.util.HttpString;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

/**
 * @Description: trace请求拦截器
 * @Author: lsr
 * @Date 2022年06月16日 15:21
 */
@Component
public class UndertowWebServerCustomizerConfig implements WebServerFactoryCustomizer<UndertowServletWebServerFactory> {
    @Override
    public void customize(UndertowServletWebServerFactory factory) {
        factory.addDeploymentInfoCustomizers(deploymentInfo -> {
            deploymentInfo.addInitialHandlerChainWrapper(new HandlerWrapper() {
                @Override
                public HttpHandler wrap(HttpHandler handler) {
                    HttpString[] disallowedHttpMethods = {HttpString.tryFromString("TRACE"),
                            HttpString.tryFromString("TRACK")};
                    return new DisallowedMethodsHandler(handler, disallowedHttpMethods);
                }
            });
        });
    }

}
