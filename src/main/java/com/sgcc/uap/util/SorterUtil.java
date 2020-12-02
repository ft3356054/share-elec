package com.sgcc.uap.util;

import org.springframework.data.domain.Sort;

import com.sgcc.uap.rest.support.RequestCondition;

public class SorterUtil {
	public static Sort sortBy(RequestCondition queryCondition) {
		Sort sort = null;
		if (queryCondition.getSorter() != null && queryCondition.getSorter() != null) {
			 String [] sorter = queryCondition.getSorter().split("=");
			 if("DESC".equals(sorter[0])){
				 sort = new Sort(Sort.Direction.DESC, sorter[1]);
			 }else
			 sort = new Sort(Sort.Direction.ASC, sorter[1]);
		}
		return sort;
    }
}
