package com.example.student.monitor.memory_cpu;

import com.sun.management.OperatingSystemMXBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

@Component
@Slf4j
public class MemoryCpuMonitor {

    @Scheduled(cron = "0/1 * * * * ?")
    public void monitor(){
        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapMemoryUsage = memoryBean.getHeapMemoryUsage();
       log.debug("Heap Memory Usage: " + heapMemoryUsage);

        OperatingSystemMXBean osBean = (com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        log.debug("System CPU Load: " + osBean.getSystemCpuLoad());
    }
}
