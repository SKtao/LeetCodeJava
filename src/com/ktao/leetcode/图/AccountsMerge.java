package com.ktao.leetcode.图;

import java.util.*;

/**
 * 721.账户合并
 * @author kongtao
 * @version 1.0
 * @description: 【Middle】
 * @date 2020/4/17
 **/
public class AccountsMerge {
    /**
     * 给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其余元素是 emails 表示该帐户的邮箱地址。
     *
     * 现在，我们想合并这些帐户。如果两个帐户都有一些共同的邮件地址，则两个帐户必定属于同一个人。请注意，即使两个帐户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。一个人最初可以拥有任意数量的帐户，但其所有帐户都具有相同的名称。
     *
     * 合并帐户后，按以下格式返回帐户：每个帐户的第一个元素是名称，其余元素是按顺序排列的邮箱地址。accounts 本身可以以任意顺序返回。
     *
     * 例子 1:
     *
     * Input:
     * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
     * Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
     * Explanation:
     *   第一个和第三个 John 是同一个人，因为他们有共同的电子邮件 "johnsmith@mail.com"。
     *   第二个 John 和 Mary 是不同的人，因为他们的电子邮件地址没有被其他帐户使用。
     *   我们可以以任何顺序返回这些列表，例如答案[['Mary'，'mary@mail.com']，['John'，'johnnybravo@mail.com']，
     *   ['John'，'john00@mail.com'，'john_newyork@mail.com'，'johnsmith@mail.com']]仍然会被接受。
     */
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();
        if (accounts == null || accounts.size() == 0) return res;
        // 每一个email和username的对应关系
        Map<String, String> emailToName = new HashMap<>();
        // 每个email与它的邻居连通email一一对应
        Map<String, Set<String>> graph = new HashMap<>();
        // 放入所有emails
        Set<String> emails = new HashSet<>();
        // 是否访问过（dfs）
        Set<String> visited = new HashSet<>();
        for (List<String> account: accounts){
            String name = account.get(0); // userName
            for (int i = 1; i < account.size(); i++){
                String email = account.get(i);
                emails.add(email);
                emailToName.put(email, name);
                graph.putIfAbsent(email, new HashSet<String>());
                if (i == 1) continue;
                // 连接当前node和前一个node，使其成为无向图
                graph.get(account.get(i - 1)).add(email);
                // index为0的位置加上username
                graph.get(email).add(account.get(i-1));
            }
        }
        for (String email : emails){
            if (!visited.contains(email)){
                visited.add(email);
                List<String> tmp = new ArrayList<>();
                tmp.add(email);
                dfs(email, graph, visited, tmp);
                Collections.sort(tmp);
                tmp.add(0, emailToName.get(email));
                res.add(tmp);
            }
        }
        return res;
    }


    private void dfs(String email, Map<String, Set<String>> graph, Set<String> visited, List<String> tmp){
        for (String nextEmail : graph.get(email)){
            if (!visited.contains(nextEmail)){
                visited.add(nextEmail);
                tmp.add(nextEmail);
                dfs(nextEmail, graph, visited, tmp);
            }
        }
    }

    public static void main(String[] args) {

    }
}
