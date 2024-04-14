package com.mybatisflex.test.mapper;

import com.mybatisflex.core.query.QueryWrapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.mybatisflex.core.query.QueryMethods.*;
import static com.mybatisflex.test.entity.table.DeviceLogTableDef.DEVICE_LOG;

@SpringBootTest
public class TestIotDevice {
    @Resource
    private DeviceLogMapper deviceLogMapper;

    @Test
    public void test() {
//        QueryWrapper subQuery = QueryWrapper.create().from(DEVICE_LOG)
//                .select(DEVICE_LOG.DEVICE_ID, max(DEVICE_LOG.CREATE_TIME).as("latest_time"))
//                .where(DEVICE_LOG.DEVICE_ID.in(1568))
//                .and(DEVICE_LOG.IDENTITY.eq("insFlow"));
//        Double l = QueryChain.of(deviceLogMapper)
//                .select(sum(DEVICE_LOG.LOG_VALUE))
//                .join(subQuery).as("t")
//                .on(
//                        DEVICE_LOG.DEVICE_ID.eq(column("t", DEVICE_LOG.DEVICE_ID.getName()))
//                                .and(DEVICE_LOG.CREATE_TIME.eq(column("t.latest_time")))
//                )
//                .where(DEVICE_LOG.IDENTITY.eq("insFlow"))
//                .objAs(Double.class);
//        System.out.println(l);

        QueryWrapper queryWrapper = QueryWrapper.create()
                .select(sum(DEVICE_LOG.LOG_VALUE))
                .join(
                        select(DEVICE_LOG.DEVICE_ID, max(DEVICE_LOG.CREATE_TIME).as("latest_time"))
                                .from(DEVICE_LOG)
                                .where(DEVICE_LOG.DEVICE_ID.in())
                                .and(DEVICE_LOG.IDENTITY.eq("insFlow"))
                                .groupBy(DEVICE_LOG.DEVICE_ID)
                ).as("t").on(
                        DEVICE_LOG.DEVICE_ID.eq(column("t", DEVICE_LOG.DEVICE_ID.getName()))
                                .and(DEVICE_LOG.CREATE_TIME.eq(column("t.latest_time"))))
                .where(DEVICE_LOG.IDENTITY.eq("insFlow"));
        System.out.println(deviceLogMapper.selectObjectByQueryAs(queryWrapper, Double.class));

    }
}
