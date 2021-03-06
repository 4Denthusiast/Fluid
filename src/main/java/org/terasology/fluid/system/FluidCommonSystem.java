/*
 * Copyright 2014 MovingBlocks
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
package org.terasology.fluid.system;


import org.terasology.assets.ResourceUrn;
import org.terasology.assets.management.AssetManager;
import org.terasology.entitySystem.systems.BaseComponentSystem;
import org.terasology.entitySystem.systems.RegisterSystem;
import org.terasology.registry.In;
import org.terasology.rendering.assets.texture.Texture;
import org.terasology.rendering.assets.texture.TextureUtil;
import org.terasology.rendering.nui.Color;

/**
 * This system is used to initialize fluid systems at launch time.
 */
@RegisterSystem
public class FluidCommonSystem extends BaseComponentSystem {
    @In
    private FluidRegistry fluidRegistry;

    @In
    private AssetManager assetManager;

    /**
     * Initializes fluid resources and textures at launch time.
     */
    @Override
    public void preBegin() {
        ResourceUrn waterTextureUri = TextureUtil.getTextureUriForColor(Color.BLUE);
        Texture texture = assetManager.getAsset(waterTextureUri, Texture.class).get();

        fluidRegistry.registerFluid("Fluid:Water", new TextureFluidRenderer(texture, "water"));
    }
}
