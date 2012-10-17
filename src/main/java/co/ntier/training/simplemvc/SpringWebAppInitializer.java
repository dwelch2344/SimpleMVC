package co.ntier.training.simplemvc;

import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.SpringServletContainerInitializer;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Bootstraps the Spring Application via Spring's automagic {@link SpringServletContainerInitializer}.
 * See {@code WebApplicationInitializer} for more information.
 *
 */
public class SpringWebAppInitializer implements WebApplicationInitializer {

	@Override
    public void onStartup(ServletContext servletContext) throws ServletException {

		// Create the 'root' Spring application context & scans anything for annotations this package
        AnnotationConfigWebApplicationContext root = new AnnotationConfigWebApplicationContext();
        root.scan( getClass().getPackage().getName() );
        
        
        // Add Spring Security Filter
        //DelegatingFilterProxy securityFilter = root.getBean(DelegatingFilterProxy.class);
		DelegatingFilterProxy securityFilter = new DelegatingFilterProxy();
        servletContext.addFilter("springSecurityFilterChain", securityFilter)
        	.addMappingForUrlPatterns(null,false,"/*");

        // Manages the lifecycle of the root application context
        servletContext.addListener(new ContextLoaderListener(root));

        // Add our DispatcherServlet to the application root
        ServletRegistration.Dynamic appServlet = servletContext.addServlet("dispatchServlet", new DispatcherServlet(root));
        appServlet.setLoadOnStartup(1);
        Set<String> mappingConflicts = appServlet.addMapping("/");
        if (!mappingConflicts.isEmpty()) {
            throw new IllegalStateException("Failed mapping");
        }
        
    }

}
