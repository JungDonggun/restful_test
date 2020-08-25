

<h2>@Annotation(어노테이션)</h4>
- <h5>@Configuration -> 해당 클래스는 Spring 설정과 관련된 파일이다 라는 것을 알려줌</h5>
- <h5>@RequiredArgsConstructor -> @Notnull, final 필드에 대해 생성자를 생성해 줍니다.</h5>
- <h5>@EnableWebSecurity -> 웹 보안을  활성화 시킴 하지만 그자체로는 유용 하지 않고 스프링 시큐리티가 WebSecurityConfigurer를 구현하거나 컨텍스트의 WebSebSecurityConfigurerAdapter를 확장한 빈으로 설정되어 있어야 한다.</h5>
- <h5>@EnableGlobalMethodSecurity -> 어노테이션 기반 보안을 적용할 수 있습니다.</h5>
