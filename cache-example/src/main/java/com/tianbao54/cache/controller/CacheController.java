package com.tianbao54.cache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tianbao54.cache.config.CacheConfig;

@Controller
@RequestMapping("/cache")
public class CacheController {
	
	@Autowired
	private CacheConfig cacheConfig;

	@RequestMapping(method = RequestMethod.GET,value = {"/cachein"})
	public @ResponseBody String cacheIn (@RequestParam String cacheName,@RequestParam String cacheKey,@RequestParam String cacheValue) {
		
		CacheManager cacheManager = cacheConfig.cacheManager();
		cacheManager.getCache(cacheName).put(cacheKey, cacheValue);
		return "cached success";
	}
	
	@RequestMapping(method = RequestMethod.GET,value = {"/cacheout"})
	public @ResponseBody String cacheOut (@RequestParam String cacheName,@RequestParam String cacheKey) {
		
		CacheManager cacheManager = cacheConfig.cacheManager();
		ValueWrapper valueWrapper = cacheManager.getCache(cacheName).get(cacheKey);
		
		if (null != valueWrapper) {
			return valueWrapper.get().toString();
		} else {
			return (cacheKey + "'s value is expired");
		}
	}
}