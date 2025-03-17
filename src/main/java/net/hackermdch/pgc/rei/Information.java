package net.hackermdch.pgc.rei;

import net.minecraft.network.chat.Component;

import java.util.List;

public record Information(String code, String name, List<String> items, List<Component> lines) {
}
