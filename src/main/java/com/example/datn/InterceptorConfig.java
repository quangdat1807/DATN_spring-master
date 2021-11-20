package com.example.datn;

import java.util.Locale;

import com.example.datn.intenceptor.GioHangInterceptor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;


@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
	@Autowired
	GioHangInterceptor gioHangIterceptor;
	
	
	
	@Bean("localeResolver")
	public LocaleResolver getLocaleResolver() {
		CookieLocaleResolver clr = new CookieLocaleResolver();
		clr.setDefaultLocale(new Locale("vi"));
		clr.setCookiePath("/");
		clr.setCookieMaxAge(60 * 60);
		return clr;
	}
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(gioHangIterceptor)
			.addPathPatterns("/check-out");
		//registry.addInterceptor(userInterceptor).addPathPatterns("/admin/*");
		// set da ngon ngu
				LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
				lci.setParamName("lang");
				registry.addInterceptor(lci);
	}	
}