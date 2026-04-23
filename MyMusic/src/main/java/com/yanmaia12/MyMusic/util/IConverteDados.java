package com.yanmaia12.MyMusic.util;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}
