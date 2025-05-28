package org.zishu;

import org.junit.jupiter.api.Test;

import java.util.UUID;

public class UUIDTest {
    @Test
    public void TestUuid(){
        for(int i = 0 ;i<10000;i++){
            System.out.println(UUID.randomUUID().toString());
        }
    }
}
