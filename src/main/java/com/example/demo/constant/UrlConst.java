package com.example.demo.constant;

public class UrlConst {
    
    /** ログイン画面 */
    public static final String LOGIN = "/login";

    /** サインアップ画面 */
    public static final String SIGNUP = "/signup";

    public static final String PLAN = "/plans";

    public static final String CONTRACT = "/contract";

    /** 認証不要画面*/
	public static final String[] NO_AUTHENTICATION = { SIGNUP, LOGIN, "/webjars/**", "/css/**" };
}
