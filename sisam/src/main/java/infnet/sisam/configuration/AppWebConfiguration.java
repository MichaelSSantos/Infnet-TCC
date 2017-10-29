package infnet.sisam.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * lasse de configuração do módulo Web do SpringMVC.
 */
@EnableWebMvc
/*@ComponentScan(basePackageClasses= {HomeController.class, UsuarioDao.class})*/
@ComponentScan(basePackages= "infnet.sisam")
public class AppWebConfiguration {

	/**
	 * Resolvedor Interno de Recursos de View
	 */
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
}
