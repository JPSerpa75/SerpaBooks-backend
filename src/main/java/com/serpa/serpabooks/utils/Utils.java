package com.serpa.serpabooks.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class Utils {

	public static <S, T> List<T> mapList(List<S> source, Class<T> targetClass, ModelMapper modelMapper) {
		return source.stream().map(element -> modelMapper.map(element, targetClass)).collect(Collectors.toList());

	}

}
