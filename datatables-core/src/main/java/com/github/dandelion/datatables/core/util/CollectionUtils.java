package com.github.dandelion.datatables.core.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import com.github.dandelion.datatables.core.configuration.Configuration;

public class CollectionUtils {

	public static Object predicateParams;

	public static <T> Collection<T> filter(Collection<T> target, Predicate<T> predicate) {
		Collection<T> result = new ArrayList<T>();
		for (T element : target) {
			if (predicate.apply(element)) {
				result.add(element);
			}
		}
		return result;
	}

	public static <T> T select(Collection<T> target, Predicate<T> predicate) {
		T result = null;
		for (T element : target) {
			if (!predicate.apply(element))
				continue;
			result = element;
			break;
		}
		return result;
	}

	public static <T> T select(Collection<T> target, Predicate<T> predicate, T defaultValue) {
		T result = defaultValue;
		for (T element : target) {
			if (!predicate.apply(element))
				continue;
			result = element;
			break;
		}
		return result;
	}
	
	public static Boolean hasConfigurationWithValue(Map<Configuration, Object> confMap, Configuration configuration, Object value) {

		if(confMap.containsKey(configuration) && confMap.get(configuration).equals(value)){
			return true;
		}

		return false;
	}
}