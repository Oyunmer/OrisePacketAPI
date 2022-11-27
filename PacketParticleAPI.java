package me.byoyunmer.packetparticleapi;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R3.EnumParticle;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles;

public class PacketSkills {
	
    public static void drawCircle(Location loc, float radius, EnumParticle enumParticle) {
        for(double t = 0; t<50; t+=0.5){
            float x = radius*(float)Math.sin(t);
            float z = radius*(float)Math.cos(t);
            PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(enumParticle, true,(float) loc.getX() + x, (float) loc.getY(),(float) loc.getZ() + z, 0, 0, 0, 0, 1);
            for(Player online : Bukkit.getOnlinePlayers()){
                ((CraftPlayer)online).getHandle().playerConnection.sendPacket(packet);
            }
        }
    }
    
    public static void drawTornado(Location loc, float radius, float height, EnumParticle enumParticle) {
        float y = (float) loc.getY();
        for(double t = 0; t<50; t+=0.05){
            float x = radius*(float)Math.sin(t);
            float z = radius*(float)Math.cos(t);
            PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(enumParticle, true,(float) loc.getX() + x, y,(float) loc.getZ() + z, 0, 0, 0, 0, 1);
            for(Player online : Bukkit.getOnlinePlayers()){
                ((CraftPlayer)online).getHandle().playerConnection.sendPacket(packet);
            }
            y += 0.01f;
            radius += height;
        }
    }
}
