package org.schhx.decorator;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author shanchao
 * @date 2018-11-13
 */
@Data
@Accessors(chain = true)
public class User {

    private String id;

    private String cellphone;

    private String name;
}
