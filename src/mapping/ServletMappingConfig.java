package mapping;

import java.util.ArrayList;
import java.util.List;

/**
 * 表现了 url 与 servlet 的映射关系
 *
 * 实际中这个类应该与 web.xml 相关联
 * */

public class ServletMappingConfig {

    public static List<ServletMapping> servletMappingList = new ArrayList<>();

    static {
        servletMappingList.add(new ServletMapping("findGirl", "/girl", "impl.FindGirlServlet"));
        servletMappingList.add(new ServletMapping("findBoy", "/boy", "impl.FindBoyServlet"));
    }
}
