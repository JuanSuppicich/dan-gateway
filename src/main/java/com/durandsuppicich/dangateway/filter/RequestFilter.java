package com.durandsuppicich.dangateway.filter;

import com.durandsuppicich.dangateway.controller.MetricController;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

public class RequestFilter extends ZuulFilter {

    @Autowired MetricController controller;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        controller.incrementCounter(request.getRequestURI());

        return null;
    }
}
