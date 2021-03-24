<<<<<<< HEAD
package com.cpf.demo.model;

import com.cpf.demo.sys.BaseModel;
import lombok.Data;

@Data
public class Mail extends BaseModel {
    /** 发送者*/
    private String sender;
    /** 接受者  */
    private String receiver;
    /** 主题 */
    private String subject;
    /** 发送 消息*/
    private String text;
    @Override
    public String toString() {
        return "Mail [sender=" + sender + ", receiver=" + receiver + ", subject=" + subject + ", text=" + text + "]";
    }
}
=======
<<<<<<< HEAD
package com.cpf.demo.model;

import com.cpf.demo.sys.BaseModel;
import lombok.Data;

@Data
public class Mail extends BaseModel {
    /** 发送者*/
    private String sender;
    /** 接受者  */
    private String receiver;
    /** 主题 */
    private String subject;
    /** 发送 消息*/
    private String text;
    @Override
    public String toString() {
        return "Mail [sender=" + sender + ", receiver=" + receiver + ", subject=" + subject + ", text=" + text + "]";
    }
}
=======
package com.cpf.demo.model;

import com.cpf.demo.sys.BaseModel;
import lombok.Data;

@Data
public class Mail extends BaseModel {
    /** 发送者*/
    private String sender;
    /** 接受者  */
    private String receiver;
    /** 主题 */
    private String subject;
    /** 发送 消息*/
    private String text;
    @Override
    public String toString() {
        return "Mail [sender=" + sender + ", receiver=" + receiver + ", subject=" + subject + ", text=" + text + "]";
    }
}
>>>>>>> 6904d88... first commit
>>>>>>> 7e2b114... first commit
