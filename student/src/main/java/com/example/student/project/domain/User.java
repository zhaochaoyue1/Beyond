package com.example.student.project.domain;

import com.example.student.annotation.PrivacyEncrypt;
import com.example.student.desensitization.CustomSerializer;
import com.example.student.desensitization.IdCardRule;
import com.example.student.desensitization.UserNameRule;
import com.example.student.enumEntity.PrivacyTypeEnum;
import com.example.student.serialize.PrivacySerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
public class User{
    @PrivacyEncrypt(type = PrivacyTypeEnum.NAME,prefixNoMaskLen = 1,suffixNoMaskLen = 0,symbol = "*")
    private Integer id;

    @PrivacyEncrypt(type = PrivacyTypeEnum.NAME,prefixNoMaskLen = 1,suffixNoMaskLen = 0,symbol = "*")
    //@CustomSerializer(UserNameRule.class)
    private String name;

    @PrivacyEncrypt(type = PrivacyTypeEnum.ID_CARD)
    //@CustomSerializer(IdCardRule.class)
    private String idCard;

    @PrivacyEncrypt(type = PrivacyTypeEnum.PHONE)
    private String phone;

    //@PrivacyEncrypt(type = PrivacyTypeEnum.EMAIL)
    private String email;

    public User() {
    }

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
