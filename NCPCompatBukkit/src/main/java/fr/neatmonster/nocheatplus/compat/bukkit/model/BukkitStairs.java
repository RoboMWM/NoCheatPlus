/*
 * This program is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package fr.neatmonster.nocheatplus.compat.bukkit.model;

import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.Bisected;
import org.bukkit.block.data.Bisected.Half;
import org.bukkit.block.data.BlockData;

import fr.neatmonster.nocheatplus.utilities.map.BlockCache;

public class BukkitStairs implements BukkitShapeModel {

    @Override
    public double[] getShape(final BlockCache blockCache, 
            final World world, final int x, final int y, final int z) {

        // TODO: With fake data, this could simply return full bounds.

        //        final Block block = world.getBlockAt(x, y, z);
        //        final BlockState state = block.getState();
        //        final BlockData blockData = state.getBlockData();
        //
        //        if (blockData instanceof Stairs) {
        //            final Stairs stairs = (Stairs) blockData;
        //            final Half half = stairs.getHalf();
        //            //final Shape shape = stairs.getShape();
        //            // TODO: Refine later, with sub shapes.
        //            switch (half) {
        //                case BOTTOM:
        //                    return new double[] {0.0, 0.0, 0.0, 1.0, 0.5, 1.0};
        //                case TOP:
        //                    return new double[] {0.0, 0.5, 0.0, 1.0, 1.0, 1.0};
        //                default:
        //                    break;
        //
        //            }
        //        }
        return new double[] {0.0, 0.0, 0.0, 1.0, 1.0, 1.0};
    }

    @Override
    public int getFakeData(final BlockCache blockCache, 
            final World world, final int x, final int y, final int z) {
        final Block block = world.getBlockAt(x, y, z);
        final BlockState state = block.getState();
        final BlockData blockData = state.getBlockData();

        if (blockData instanceof Bisected) {
            final Bisected stairs = (Bisected) blockData;
            final Half half = stairs.getHalf();
            //final Shape shape = stairs.getShape();
            // TODO: Refine later, with sub shapes.
            switch (half) {
                case TOP:
                    return 0x4;
                default:
                    break;
            }
        }
        return 0;
    }

}
