# Spring-JWT

# JWT IMPLEMENTING 8 STEPS:

- Add dependency (io.jsonwebtoken)
- Create JWTAuthenticationEntryPoint Implements AuthenticationEntryPoint(interface)
- Create JWTTokenHelper
- JwtAuthenticationFilter extends OnceRequestFilter
  a- Get jwt token from resquest
  b- Validate token
  c- get user from token
  d- Load user associated with token
  e- Set spring security
- Create JwtAuthResponse
- Configure JWT in spring security config
- Create login api to retturn token
- Test application
