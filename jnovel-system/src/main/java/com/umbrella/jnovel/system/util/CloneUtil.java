package com.umbrella.jnovel.system.util;

import java.io.*;

/**
 * @Description 深拷贝工具
 * @Author becktte
 * @Date 2019/11/1
 * @Version 1.0
 **/
public class CloneUtil {

    public <T extends Serializable> T clone(T obj) {
        T cloneObj = null;
        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             ObjectOutputStream obs = new ObjectOutputStream(out)) {
            obs.writeObject(obj);
            try (ByteArrayInputStream bis = new ByteArrayInputStream(out.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis)) {
                cloneObj = (T) ois.readObject();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cloneObj;
    }

}
