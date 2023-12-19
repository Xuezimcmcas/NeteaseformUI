package me.zhanshi.formuiplugin.commandExe;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;

import org.geysermc.cumulus.form.ModalForm;
import org.geysermc.cumulus.form.SimpleForm;
import org.geysermc.cumulus.util.FormImage;

import com.neteasemc.spigotmaster.SpigotMaster;

public class CommandShowForm implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        SpigotMaster spigotMaster = (SpigotMaster) Bukkit.getPluginManager().getPlugin("SpigotMaster");
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length > 0) {
                int type = Integer.parseInt(args[0]);
                switch (type) {
                    case 1:

                        ModalForm.Builder builder = ModalForm.builder()
                                .title("§6§l苦力怕头收集者")
                                .content("§f§l在大厅散落了五个苦力怕头颅,你能帮我找到它们吗?我会给你丰厚的报酬")
                                .button1("§a§l好的")
                                .button2("§c§l但是,我拒绝")
                                .validResultHandler((response) -> {
                                    if (response.clickedFirst()) {
                                        player.sendTitle("§d§lTIP", "§f§l找到苦力怕头后请长按头颅即可领取", 10, 60, 10);
                                        return;
                                    }
                                    player.sendTitle("§7§l好吧，告辞", "", 10, 40, 10);
                                });
                        spigotMaster.sendForm(player, builder);
                        break;
                    case 2:
                        SimpleForm simpleForm = SimpleForm.builder()
                                .title(ChatColor.GREEN + "游戏选择菜单")
                                .content("游戏列表")
                                .button(ChatColor.YELLOW + "§l起床战争", FormImage.Type.URL, "http://43.248.184.64:7979/R.png")
                                .button(ChatColor.BLUE + "§l科技生存", FormImage.Type.URL, "http://43.248.184.64:7979/C.png")
                                .button("§a§l粘液空岛生存", FormImage.Type.URL, "http://43.248.184.64:7979/S.png")
                                .validResultHandler((response) -> {
                                    int buttonId = response.clickedButtonId();
                                    Player player1 = (Player) sender;
                                    switch (buttonId) {
                                        case 0:
                                            Bukkit.getServer().dispatchCommand(sender, "server Bedwarlobby");
                                            break;
                                        case 1:
                                            Bukkit.getServer().dispatchCommand(sender, "server RevivalSurvival2");
                                            break; //按钮的顺序从0往下
                                        case 2:
                                            Bukkit.getServer().dispatchCommand(sender, "server Skyblock");
                                    }
                                })
                                .build();
                        spigotMaster.sendForm(player, simpleForm);
                        break;
                    case 3:
                        ModalForm.Builder builder1 = ModalForm.builder()
                                .title("§6§l用户协议")
                                .content("欢迎加入我们的VKCraft服务器！在你开始使用我们的服务器之前，请仔细阅读以下用户协议。\n\n" +
                                        "通过加入并使用我们的服务器，你同意遵守以下规则和规定：\n\n" +
                                        "§l行为规范:\n" +
                                        "§f1. 不允许恶意行为：禁止在服务器上进行恶意破坏、恶作剧、辱骂或骚扰其他玩家\n" +
                                        "§f2. 尊重他人：请尊重其他玩家的隐私和个人空间，不要在未经允许的情况下进入他们的领地或触及他们的物品\n" +
                                        "§f3. 使用适当的语言：请使用适当的语言，不要发布淫秽、令人不悦或冒犯性的内容\n\n" +
                                        "§l游戏内规则:\n" +
                                        "§f1. 禁止使用外挂和作弊：禁止使用外挂、作弊程序或其他不正当手段来获得游戏优势\n" +
                                        "§f2. 不要滥用服务器资源：不要故意导致服务器卡顿或崩溃。请合理使用服务器资源\n" +
                                        "§f3. 遵守游戏内规则：请遵守服务器内部规则，如领地规定、商店规则等\n\n" +
                                        "§l知识产权:\n" +
                                        "§f1. 请尊重知识产权：请不要在服务器上发布侵犯他人知识产权的内容，包括但不限于盗版、侵权的建筑或纹理包\n" +
                                        "§f2. 知识产权的归属：任何在服务器上创建的建筑或创作物的知识产权归属于创作者。请尊重他们的权利\n\n" +
                                        "§l隐私政策:\n"+
                                        "§f我们会尽力保护你的个人信息，请阅读我们的隐私政策以了解更多信息\n\n"+
                                        "§l最终解释权:\n" +
                                        "§f1. VKCraft团队保留对这些规定的最终解释权，并有权根据需要进行修改")
                                .button1("§a§l好的")
                                .button2("§c§lVKCraft服务器隐私政策")
                                .validResultHandler((response) -> {
                                    int buttonId = response.clickedButtonId();
                                    Player player1 = (Player) sender;
                                    switch (buttonId) {
                                        case 0:
                                            player.sendTitle("§f§lVKCr§6§laft", "§k1§f§l创造无限可能§k1", 10, 80, 10);
                                            break;
                                        case 1:
                                            Bukkit.getServer().dispatchCommand(sender, "showform 4");
                                            break; //按钮的顺序从0往下
                                    }
                                });
                        spigotMaster.sendForm(player, builder1);
                        break;
                    case 4:
                        ModalForm.Builder builder2 = ModalForm.builder()
                                .title("§6§lVKCraft服务器隐私政策")
                                .content("欢迎使用我们的VKCraft服务器！我们致力于保护你的隐私和个人信息。本隐私政策将解释我们如何收集、使用和保护你的个人信息。请仔细阅读本政策\n" +
                                        "§l1 收集的信息\n" +
                                        "我们可能会收集以下类型的信息：\n" +
                                        "§l游戏相关信息：§f包括你在游戏内的用户名、游戏进程、交互记录以及其他与游戏相关的信息\n" +
                                        "§lIP地址和日志信息：§f我们可能会自动收集你的IP地址和服务器日志信息，以帮助我们分析和维护服务器的性能\n" +
                                        "§lCookies和类似技术：§f我们可能会使用Cookies或类似的技术来收集信息，以改善你的浏览体验\n" +
                                        "§l用户提供的信息：§f如果你选择与我们联系、报告问题或提供反馈意见，你可能会提供个人信息，如电子邮件地址\n" +
                                        "§l2 使用信息\n" +
                                        "我们可能会使用你的个人信息来：\n" +
                                        "§l游戏体验：§f以提供更好的游戏体验，包括支持、互动和改进服务器性能\n" +
                                        "§l联系：§f如果你联系我们，我们可能会使用你提供的信息来回应你的请求或问题\n" +
                                        "§l安全和合规：§f以确保服务器的安全性和合规性，包括应对违规行为\n" +
                                        "§l信息分享\n" +
                                        "我们不会出售、出租或以任何方式分享你的个人信息，除非：\n" +
                                        "§l合法请求：§f我们可能会根据法律要求或法院命令分享信息\n" +
                                        "§l合作伙伴：§f我们可能会与第三方服务提供商合作，以提供服务器服务。这些服务提供商可能会访问你的个人信息，但仅限于执行与服务器服务相关的任务\n" +
                                        "§l隐私权更新\n" +
                                        "我们可能会定期更新隐私政策，以反映法律要求、服务变更或其他因素。请定期查看我们的隐私政策，以了解最新信息")
                                .button1("§a§l好的")
                                .button2("§c§l返回上一级")
                                .validResultHandler((response) -> {
                                    int buttonId = response.clickedButtonId();
                                    Player player1 = (Player) sender;
                                    switch (buttonId) {
                                        case 0:
                                            player.sendTitle("§f§lVKCr§6§laft", "§k1§f§l创造无限可能§k1", 10, 80, 10);
                                            break;
                                        case 1:
                                            Bukkit.getServer().dispatchCommand(sender, "showform 3");
                                            break; //按钮的顺序从0往下
                                    }
                                });
                        spigotMaster.sendForm(player, builder2);
                        break;
                    case 5 :
                        SimpleForm customSimpleForm = SimpleForm.builder()
                                .title("§gTitle")
                                .content("Content")
                                .button("111", FormImage.Type.PATH,  "textures/ui/btn1.png") // clickedButtonId == 0
                                .button("测试按钮2", FormImage.Type.PATH,  "textures/ui/btn1.png") // clickedButtonId == 1
                                .button("测试按钮3", FormImage.Type.PATH,  "textures/ui/btn1.png") // clickedButtonId == 2
                                .button("测试按钮4", FormImage.Type.PATH,  "textures/ui/btn1.png") // clickedButtonId == 3
                                .button("测试按钮5", FormImage.Type.PATH,  "textures/ui/btn1.png") // clickedButtonId == 4
                                .button("测试按钮6", FormImage.Type.PATH,  "textures/ui/btn1.png") // ...
                                .button("测试按钮7", FormImage.Type.PATH,  "textures/ui/btn1.png") // ...
                                .button("测试按钮8", FormImage.Type.PATH,  "textures/ui/btn1.png") // ...
                                .button("测试按钮9", FormImage.Type.PATH,  "textures/ui/btn1.png") // ...
                                .button("测试按钮10", FormImage.Type.PATH, "textures/ui/btn1.png") // ...
                                .button("测试按钮11", FormImage.Type.PATH, "textures/ui/btn1.png") // ...
                                .button("测试按钮12", FormImage.Type.PATH, "textures/ui/btn1.png") // ...
                                .build();
                        spigotMaster.sendForm(player, customSimpleForm);
                    default:
                        break;
                }
            }
        }
        return true;
    }
}