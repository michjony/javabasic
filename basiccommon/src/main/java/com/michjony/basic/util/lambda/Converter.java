package com.michjony.basic.util.lambda;

@FunctionalInterface
public interface Converter<F,T> {
	T convert(F from);
}
