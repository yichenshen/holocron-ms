/*
    This file is part of the Holocron MS MapleStory Server
    Copyleft (L) 2026 yichenshen

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU Affero General Public License as
    published by the Free Software Foundation version 3 as published by
    the Free Software Foundation. You may not use, modify or distribute
    this program under any other version of the GNU Affero General Public
    License.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Affero General Public License for more details.

    You should have received a copy of the GNU Affero General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
package client.command.commands.gm4;

import client.Character;
import client.Client;
import client.command.Command;
import tools.PacketCreator;

/**
 * @author yichenshen
 */
public class EquipDropMulCommand extends Command {
    {
        setDescription("Set world equipment drop multiplier.");
    }

    @Override
    public void execute(Client c, String[] params) {
        Character player = c.getPlayer();
        if (params.length < 1) {
            player.yellowMessage("Syntax: !equipdropmul <new multiplier>");
            return;
        }

        float equipdropmul = Math.max(Float.parseFloat(params[0]), 1.0f);
        c.getWorldServer().setEquipDropMul(equipdropmul);
        c.getWorldServer().broadcastPacket(PacketCreator.serverNotice(6, "[Rate] Equipment Drop multiplier has been changed to " + equipdropmul + "x."));
    }
}
