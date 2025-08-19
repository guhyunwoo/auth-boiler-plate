# Auth-Boilerplate

Spring Boot 기반 JWT 인증 보일러플레이트입니다.
회원가입, 로그인, 로그아웃, 토큰 리프레시 등 **JWT 기반 인증** 기능을 빠르게 구현할 수 있도록 설계했습니다.

---

## 주요 기능

*  회원가입 (Sign Up)
*  로그인 (Login)
*  로그아웃 (Logout)
*  Access Token / Refresh Token 기반 인증
*  JWT 토큰 발급 및 검증
*  Refresh Token으로 Access Token 갱신

---

## 기술 스택

* Java 21
* Spring Boot 3.5.4
* Spring Security
* JJWT 0.12.6
* Gradle
* MySQL
* Redis

---

## 설치 및 실행

1. 레포지토리 클론

```bash
git clone https://github.com/guhyunwoo/auth-boilerplate.git
cd auth-boilerplate
```

2. 의존성 설치 및 빌드

```
./gradlew clean build
```

3. 애플리케이션 실행

```
./gradlew spring-boot:run
```

---

## API 예시

| 기능               | 엔드포인트               | 메서드  |
| ---------------- | ------------------- | ---- |
| 회원가입             | `/users/register`  | POST |
| 로그인              | `/users/login`   | POST |
| 로그아웃             | `/users/logout`  | DELETE |
| Access Token 재발급 | `/users/refresh` | POST |


> 각 엔드포인트는 JWT 토큰을 사용하여 인증/인가 처리됩니다.

---

## 토큰 구조

* **Access Token**: 짧은 유효기간, API 접근용
* **Refresh Token**: 상대적으로 긴 유효기간, Access Token 갱신용

---

## 특징

* 보일러플레이트용 구조로, 다른 프로젝트에 쉽게 통합 가능
* Spring Security 기반으로 확장 용이
* JWT 예외 처리 및 커스텀 응답 구조 제공

---

## 향후 개선 예정

* OAuth2 연동
* 이메일 인증 기능

---

## 라이선스

MIT License
