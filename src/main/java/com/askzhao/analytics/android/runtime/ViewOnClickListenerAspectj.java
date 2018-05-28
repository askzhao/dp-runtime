package com.askzhao.analytics.android.runtime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class ViewOnClickListenerAspectj {

    /**
     * 支持 butterknife.OnClick 注解
     */
    @Pointcut("execution(@butterknife.OnClick * *(..))")
    public void methodAnnotatedWithButterknifeClick() {
    }

    @After("methodAnnotatedWithButterknifeClick()")
    public void onButterknifeClickAOP(final JoinPoint joinPoint) throws Throwable {
        AopUtil.sendTrackEventToSDK(joinPoint, "onButterknifeClick");
    }

    /**
     * android.view.View.OnClickListener.onClick(android.view.View)
     *
     * @param joinPoint JoinPoint
     * @throws Throwable Exception
     */
    @After("execution(* android.view.View.OnClickListener.onClick(android.view.View))")
    public void onViewClickAOP(final JoinPoint joinPoint) throws Throwable {
        AopUtil.sendTrackEventToSDK(joinPoint, "onViewOnClick");
    }

//    @After("execution(* com.fancard.askzhao.dp_sdk_android.OnSingleClickListener.onSingleClick(android.view.View))")
//    public void onViewClickAOP2(final JoinPoint joinPoint) throws Throwable {
//        AopUtil.sendTrackEventToSDK(joinPoint, "onViewOnClick");
//    }
    /**
     * android.view.View.OnLongClickListener.onLongClick(android.view.View)
     *
     * @param joinPoint JoinPoint
     * @throws Throwable Exception
     */
    @After("execution(* android.view.View.OnLongClickListener.onLongClick(android.view.View))")
    public void onViewLongClickAOP(JoinPoint joinPoint) throws Throwable {

    }



    @After("execution(* android.text.TextWatcher.afterTextChanged(android.text.Editable))")
    public void onTextChanged(final JoinPoint joinPoint) throws Throwable {
        AopUtil.sendTrackEventToSDK(joinPoint, "onViewOnClick");
    }

}
