# 13장 서비스의 인증과 권한 부여
##### 애플리케이션을 개발하다 보면, 인증과 인가 등의 보안 기능 추가
##### 보안을 위해 스프링 Spring Security가 있음 <br></br>


## 13.1 보안 용어 이해
##### ✅ 인증 (Authentication)
* 사용자가 누구인지 확인하는 단계
* 확인이 되면, 서버가 유저에게 토큰 전달
* 토큰을 이용하여 유저는 원하는 리소스에 접근 가능

##### ✅ 인가 (Authorization)
* 검증된 유저가 애플리케이션 내부의 리소스에 접근할 때 해당 리소스에 접근할 권리가 있는지 확인하는 과정
* 인증 단계에서 발급 받은 토큰은 인가 내용 포함

##### ✅ 접근 주체 (Principal)
* 애플리케이션을 사용하는 주체
* 사용자, 디바이스, 시스템이 될 수 있음
* 인증 과정을 통해 접근 주체가 신뢰할 수 있는지 확인 후, 인가 과정을 통해 접근 주체에게 부여되는 권한을 확인하는 과정 <br></br>


## 13.2 스프링 시큐리티
* 애플리케이션의 인증, 인가 등의 보안 기능을 제공하는 스프링 하위 프로젝트 중 하나
* 보안 관련된 많은 기능 제공 <br></br>


## 13.3 스프링 시큐리티의 동작 구조
* DispatcherServlet 앞에 필터 배치 <br></br>

* **필터체인(Filter Chain)** 은 서블릿 컨테이너에서 관리하는 ApplicationsFilterChain
* 클라이언트에서 요청을 보내면 서블릿 컨테이너는 URI를 확인해서 필터와 서블릿 매핑 <br></br>

* 서블릿 컨테이너의 필터 사이에서 동작시키기 위해 DelegatingFilterProxy 사용
> DelegatingFilterProxy
>* 서블릿 컨테이너의 생명주기와 스프링 애플리케이션 컨텍스트 사이에서 다리 역할을 하는 필터 구현체
>* 표준 서블릿 필터 구현, 역할을 위임할 필터체인 프록시를 내부에 가지고 있음 (Bean Filter)
>* 필터체인 프록시는 자동 생성
>* 보안 필터체인은 WebSecurityConfigurerAdapter 클래스를 상속받아 설정

##### <br></br>  인증 수행 과정 <br></br>


## 13.4 JWT
##### ✅ JWT(JSON Web Token)는 정보를 JSON 형태로 안전하게 전송하기 위한 토큰
* URL로 이용할 수 있는 문자열로만 구성 ➡️ HTTP 구성요소 어디든 위치 가능
* 디지털 서명이 적용되어 있음 ➡️ 신뢰 가능
* 주로 서버와의 통신에서 권한 인가를 위해 사용 <br></br>

### 13.4.1 JWT 구조
##### - Header (헤더)
##### &nbsp; &nbsp; 검증과 관련된 내용을 담음
##### - Payload (내용)
##### &nbsp; &nbsp; 토큰에 담긴 정보 포함
##### - Signature (서명)
##### &nbsp; &nbsp; 인코딩된 헤더, 인코딩된 내용, 비밀키, 헤더의 알고리즘 속성값을 가져와 생성

### 13.4.2 JWT 디버거 사용하기 <br></br>


## 13.5 스프링 시큐리티와 JWT 적용
##### ✅ security 프로젝트 생성
##### ✅ 스프링 시큐리티와 JWT 의존성 추가 <br></br>

### 13.5.1 UserDetails와 UserDetailsService 구현
##### User 엔티티 생성
* UserDetails 인터페이스 구현 (UserDetailsService를 통해 입력된 로그인 정보를 가지고 데이터베이스에서 사용자 정보를 가져오는 역할)
>* getAuthorities()
>* getPassword()
>* getUsername()
>* isAccountNonExpired()
>* isAccountNonLocked()
>* isCredentialNonExpired()
>* isEnabled()
* 토큰을 생성할 때 토큰의 정보로 사용될 정보와 권한 정보를 갖게 됨

### 13.5.2 JwtTokenProvider 구현
* JWT 토큰을 생성하는 데 필요한 정보를 UserDetails에서 가져올 수 있음
* JWT 토큰을 생성하는 JwtTokenProvider를 생성해야 함

### 13.5.3 JwtAuthenticationFilter 구현
* JWT 토큰으로 인증하고 SecurityContextHolder에 추가하는 필터를 설정하는 클래스

### 13.5.4 SecurityConfiguration 구현
* 스프링 시큐리티와 관련된 설정
* 대표적으로 WebSecurityConfigurerAdapter를 상속받는 Configuration 클래스를 구현

### 13.5.5 커스텀 AccessDeniedHandler, AuthenticationEntryPoint 구현
* 인증과 인가 과정의 예외 상황에서 CustomAccessDeniedHandler와 CustomAuthenticationEntryPoint로 예외 전달
* CustomAccessDeniedHandler : 엑세스 권한이 없는 리소스에 접근할 경우 발생하는 예외 ➡️ 리다이렉트하여 정의한 예외 메서드 호출
* CustomAuthenticationEntryPoint : 직접 Response를 생성해서 클라이언트에게 응답


### 13.5.6 회원가입과 로그인 구현
##### 회원가입
##### 로그인
* id를 기반으로 UserRepository에서 User 엔티티를 가져옴
* PasswordEncoder를 사용해 db에 저장되어 있던 비밀번호와 입력받은 비밀번호가 일치하는지 확인
* 비밀번호가 일치해서 인증 통과 ➡️ TokenProvider를 통해 id와 role 값을 전달해서 토큰 생성 후 Response에 담음


## 13.6 정리
