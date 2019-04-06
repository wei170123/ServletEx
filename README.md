# Note
Learning note for servlet & eclipse

## Index

	CH2
      - ContextRoot設定
      - web.xml
	  - ContextPath 環境路徑
	  - X-FORWARDED-FOR
	  
	CH3
	  - eclipse 無法執行專案問題
      - serialVersionUID 功能
      
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

### CH3

  - eclipse 無法執行Clone專案問題
	1. JRE及Tomcat路徑錯誤
	   從Build Path重新設定
    2. 因为下载下来的專案没有eclipse的相關配置設定，eclipse不知道这是一个什么项目。
	   專案 Build Path > Project Facets > 選擇 Dynamic Web Module和java
	  
  - serialVersionUID 功能
      作為Java對象序列化中的版本標示之用
	  當一個class實現了Serializable介面，如果沒有定義serialVersionUID，Eclipse會提供這個提示功能告訴使用者去定義之。
	  
### CH4

  - HttpOnly
	1. 設置Document不能直接存取Cookie
    2. 避免JS透過Document存取Cookie，防止簡易XSS
	  
  - HttpSevletRequest 功能
      getSession() > 預設true，沒有session物件，則自動產生
	  getSession(false) > 沒有session物件，則回傳null
	  
	  