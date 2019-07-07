/*
 * Copyright 2019 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.terasology.ligthandshadow.componentsystem.controllers;

import org.terasology.entitySystem.entity.EntityManager;
import org.terasology.entitySystem.entity.EntityRef;
import org.terasology.entitySystem.systems.BaseComponentSystem;
import org.terasology.entitySystem.systems.RegisterSystem;
import org.terasology.ligthandshadow.componentsystem.components.LASGlobalEntityComponent;
import org.terasology.registry.In;
import org.terasology.registry.Share;

@RegisterSystem
@Share(value = LASGlobalEntitySystem.class)
public class LASGlobalEntitySystem extends BaseComponentSystem {

    private EntityRef globalEntity = EntityRef.NULL;

    @In
    private EntityManager entityManager;

    public EntityRef getEntity() {
        if (globalEntity.equals(EntityRef.NULL)) {
            if (entityManager.getCountOfEntitiesWith(LASGlobalEntityComponent.class) == 0) {
                globalEntity = entityManager.create("lasGlobalEntity");
            } else {
                globalEntity = entityManager.getEntitiesWith(LASGlobalEntityComponent.class).iterator().next();
            }
        }
        return globalEntity;
    }
}
