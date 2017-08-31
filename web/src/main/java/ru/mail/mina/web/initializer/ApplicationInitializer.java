package ru.mail.mina.web.initializer;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import ru.mail.mina.web.config.AppConfig;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import static org.springframework.http.HttpHeaders.LOCATION;
/**
 * Created by Администратор on 16.08.2017.
 */
public class ApplicationInitializer  extends AbstractAnnotationConfigDispatcherServletInitializer
        implements WebApplicationInitializer {

    private static final String LOCATION = "D:\\projectData";
    private static final long MAX_FILE_SIZE = 5242880;
    private static final long MAX_REQUEST_SIZE = 20971520;
    private static final int FILE_SIZE_THRESHOLD = 0;

    public void onStartup(ServletContext container) throws ServletException {

        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(AppConfig.class);
        ctx.setServletContext(container);

        ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(ctx));
        servlet.setMultipartConfig(getMultipartConfigElement());
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }


    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{AppConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }


    private MultipartConfigElement getMultipartConfigElement() {
        return new MultipartConfigElement( LOCATION, MAX_FILE_SIZE, MAX_REQUEST_SIZE, FILE_SIZE_THRESHOLD);
    }
}
