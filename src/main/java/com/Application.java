package com;

/**
 * spring boot 入口文件
 * @author Robert.Jiang
 * @date 2019年5月21日 上午10:49:35
 */
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
@MapperScan("com.jiangxing.mapper")
public class Application {
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
