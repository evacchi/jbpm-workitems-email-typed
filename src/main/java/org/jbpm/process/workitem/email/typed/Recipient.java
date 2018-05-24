/*
 * Copyright 2018 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jbpm.process.workitem.email.typed;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

public class Recipient {
    enum Type { TO, CC, BCC }
    private Type type;

    private String displayName;

    @Email
    private String email;

    @Pattern(regexp = "[+]\\d{2}[(]\\d{2}[)]\\d{4}[\\-]\\d{4}")
    private String mobile;

    public static Recipient to(String email) {
        Recipient recipient = new Recipient();
        recipient.email = email;
        recipient.type = Type.TO;
        return recipient;
    }

    public static Recipient cc(String email) {
        Recipient recipient = new Recipient();
        recipient.email = email;
        recipient.type = Type.CC;
        return recipient;
    }

    public static Recipient bcc(String email) {
        Recipient recipient = new Recipient();
        recipient.email = email;
        recipient.type = Type.BCC;
        return recipient;
    }



    public Recipient() {
    }

    public Recipient(Type type,
                     String displayName,
                     String email,
                     String mobile) {
        this.type = type;
        this.displayName = displayName;
        this.email = email;
        this.mobile = mobile;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((displayName == null) ? 0 : displayName.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if ( this == obj ) return true;
        if ( obj == null ) return false;
        if ( getClass() != obj.getClass() ) return false;
        final Recipient other = (Recipient) obj;
        if ( displayName == null ) {
            if ( other.displayName != null ) return false;
        } else if ( !displayName.equals( other.displayName ) ) return false;
        if ( email == null ) {
            if ( other.email != null ) return false;
        } else if ( !email.equals( other.email ) ) return false;
        if ( mobile == null ) {
            if ( other.mobile != null ) return false;
        } else if ( !mobile.equals( other.mobile ) ) return false;
        if ( type == null ) {
            if ( other.type != null ) return false;
        } else if ( !type.equals( other.type ) ) return false;
        return true;
    }

}