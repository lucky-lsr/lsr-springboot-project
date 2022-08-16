package cn.lsr.boot.core.listener;

import cn.lsr.boot.core.constant.ListenerOrder;
import cn.lsr.boot.core.event.ApplicationEventPublishType;
import cn.lsr.boot.core.event.ApplicationGlobalEvent;
import cn.lsr.boot.core.param.SystemParamManagerConstant;
import cn.lsr.boot.core.param.SystemParamManagerUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @Description: 系统参数校验listener
 * @Author: lsr
 * @Date 2022年08月06日 16:41
 */
@Component
public class SystemParamCheckListener implements ApplicationListener<ApplicationGlobalEvent>, Ordered {
    private Logger log = LogManager.getLogger(SystemParamCheckListener.class);

    @Override
    public void onApplicationEvent(ApplicationGlobalEvent status) {
        if (ApplicationEventPublishType.INIT == status.getSource()) {
            //参数校验
            log.info("****************** param check start ******************");
            validateEmpty(SystemParamManagerConstant.systemId, SystemParamManagerUtils.getSystemId());
            validateEmpty(SystemParamManagerConstant.logHome, SystemParamManagerUtils.getLogHome());
            log.info("****************** param check end ******************");
        }
    }

    @Override
    public int getOrder() {
        return ListenerOrder.SYS_PARAM_CHECK_INIT;
    }

    /**
     * 校验参数是否为空
     *
     * @param name
     * @param value
     */
    private void validateEmpty(String name, String value) {
        if (StringUtils.isEmpty(value)) {
            throw new RuntimeException(name + " cannot be empty");
        }
    }
}
