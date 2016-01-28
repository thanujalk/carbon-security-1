/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.carbon.security.jaas;

import org.wso2.carbon.security.util.AuthorizationManager;

import java.io.Serializable;
import java.security.Principal;

/**
 *
 */
public class CarbonPrincipal implements Principal, Serializable {

    private static final long serialVersionUID = 6056209529374720080L;

    private String name;

    public CarbonPrincipal() {

    }

    public CarbonPrincipal(String name) {

        this.name = name;
    }

    @Override
    public boolean equals(Object another) {

        if (another instanceof CarbonPrincipal) {
            //TODO add logic to compare
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {

        return 0;
    }

    @Override
    public String getName() {

        return this.name;
    }

    public boolean isAuthorized(CarbonPermission carbonPermission) {

        if (carbonPermission == null) {
            throw new IllegalArgumentException("Permission object cannot be null");
        }

        return (AuthorizationManager.getInstance().authorizePrincipal(this.getName(), carbonPermission));

    }


}
