package com.tianbao54.cache.test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.io.Files;
import com.google.common.primitives.Ints;

public class CacheTest {

	@Test
	public void testGuava () {
		Map<String,String> map = Maps.newHashMap();
		List <?> list = Lists.newArrayList();
		Set <?> set = Sets.newHashSet();
		
		list = ImmutableList.of("list1","list2","list3");
		System.out.println(list);
		set = ImmutableSet.of("set1","set2","set3");
		System.out.println(set);
		map = ImmutableMap.of("key1", "value1","key2", "value2");
		System.out.println(map);
		
		
		try {
			list = Files.readLines(new File ("c:/AirTest.csv"), Charsets.UTF_8);
			System.out.println(list);
		} catch (IOException e) {
			e.printStackTrace();
		}
		int compare = Ints.compare(1, 1);
		System.out.println(compare);
		
	}
}