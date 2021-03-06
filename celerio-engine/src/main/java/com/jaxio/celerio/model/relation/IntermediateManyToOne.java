/*
 * Copyright 2015 JAXIO http://www.jaxio.com
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

package com.jaxio.celerio.model.relation;

import com.jaxio.celerio.model.Entity;
import com.jaxio.celerio.model.Relation;
import com.jaxio.celerio.support.Namer;
import lombok.Getter;

@Getter
public class IntermediateManyToOne extends AbstractIntermediateRelation {

    public IntermediateManyToOne(Namer from, Namer to, Entity middleEntity, Relation middleToLeft, Relation middleToRight) {
        super(from, to, middleEntity, middleToLeft, middleToRight);
    }

    @Override
    final public boolean isManyToOne() {
        return true;
    }

    @Override
    protected IntermediateOneToMany buildInverse() {
        return new IntermediateOneToMany(getTo(), getFrom(), getMiddleEntity(), getMiddleToRight(), getMiddleToLeft());
    }

    @Override
    public String getLabelName() {
        return getFromEntity().getModel().getVar() + "_" + getTo().getVar();
    }
}