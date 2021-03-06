package com.cxplan.projection.mediate.message.handler.ime;

import com.cxplan.common.util.LogUtil;
import com.cxplan.projection.mediate.CXApplication;
import com.cxplan.projection.mediate.Constant;
import com.cxplan.projection.mediate.message.Message;
import com.cxplan.projection.mediate.message.MessageException;
import com.cxplan.projection.mediate.message.MessageUtil;
import com.cxplan.projection.mediate.message.handler.AbstractCommandHandler;

import org.apache.mina.core.session.IoSession;
/**
 * Created on 2018/5/19.
 *
 * @author kenny
 */
public class IMEStateCommandHandler extends AbstractCommandHandler {
    private static final String TAG = Constant.TAG_PREFIX + "IME";

    public IMEStateCommandHandler() {
        super(MessageUtil.CMD_DEVICE_IME);
    }

    @Override
    public void process(IoSession session, Message message) throws MessageException {
        //init connection
        String action = message.getParameter("action");
        LogUtil.i(TAG, "The ime action: " + action);
        switch (action) {
            case "bind":
                CXApplication.isIMERunning = true;
                break;
            case "unbind":
                CXApplication.isIMERunning = false;
                break;

        }
    }

}
