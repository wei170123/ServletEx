# Note
Learning note for servlet & eclipse

## Index

1. CH2
      - ContextRoot設定
      - web.xml
      
### CH2

  - ContextRoot設定
      修正URL路徑
      1. Tomcat > context.xml
      2. Eclipse > Project Name > 右鍵 > Properties > Web Project Settings
	  
  - web.xml
      可配置@WebServlet設定

```sh
        <servlet>
		<servlet-name>xmlHello</servlet-name>
		<servlet-class>pers.mw.exercises.HelloServlet</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>xmlHello</servlet-name>
		<url-pattern>/xmlHello</url-pattern>
	</servlet-mapping>
```

  - ContextPath 環境路徑
      Web容器用來挑選要執行的Web應用程式
	  
  - ContextPath 根路徑下可直接存取
  
  - X-FORWARDED-FOR 從此取得IP有偽造的可能性
