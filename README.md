# sso-github
Spring boot Project with Spring Security for SSO with GitHub
+ Major Steps of development
  + Register our app at 
  *https://github.com/settings/applications/new*
  + Get client ID and client Secret
  + Use them in our Spring Boot application
  + Enable oauth2Login()
+ Major Steps of Testing
  + Visit http://localhost:8080 on a web browser
  + Browser redirects to GitHub login; Sign in to GitHub
  + Authorize for your GitHub account's information is accessible by the owner of the app.
  + Browser shows "You are being redirected to the authorized application."
  + Immediately, after that browser redirects us to our configured URL.
  + Read token information in the Server Log
