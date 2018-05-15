package com.askzhao.analytics.android.runtime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;


@Aspect
public class RadioGroupOnCheckedChangeAspectj {
    private final static String TAG = RadioGroupOnCheckedChangeAspectj.class.getCanonicalName();

    @After("execution(* android.widget.RadioGroup.OnCheckedChangeListener.onCheckedChanged(android.widget.RadioGroup,int))")
    public void onCheckedChangedAOP(final JoinPoint joinPoint) throws Throwable {
        AopUtil.sendTrackEventToSDK(joinPoint, "onRadioGroupCheckedChanged");
    }
}