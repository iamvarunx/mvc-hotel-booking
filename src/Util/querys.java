package Util;

public class querys {
    public static String display_Bycity() {
        String Query = "SELECT\n" + //
                "    hd.Hotel_id\n," + //
                "rt.Room_id,\n" + //
                "    hd.Hotel_city,\n" + //
                "    hd.Hotel_contact,\n" + //
                "    rt.Room_type,\n" + //
                "     r.no_of_rooms,\n" + //
                "    rt.no_of_person,\n" + //
                "    rt.pricePerDay\n" + //
                "FROM\n" + //
                "    hotel_rooms r\n" + //
                "LEFT JOIN\n" + //
                "    booking_table b ON r.Hotel_id = b.Hotel_id AND r.Room_id = b.Room_id\n" + //
                "LEFT JOIN\n" + //
                "    Branch_details hd ON r.Hotel_id = hd.Hotel_id\n" + //
                "LEFT JOIN\n" + //
                "    Room_types rt ON r.Room_id = rt.Room_id\n" + //
                "WHERE\n" + //
                "\thd.Hotel_city = ?;";
        return Query;
    }

    public static String display_city_update_query() {
        String Query = "SELECT\n" + //
                "    r.Room_id,\n" + //
                "    hd.Hotel_id\n" + //
                "\thd.Hotel_address,\n" + //
                "    hd.Hotel_city,\n" + //
                "    rt.Room_type,\n" + //
                "     r.no_of_rooms,\n" + //

                "FROM\n" + //
                "    hotel_rooms r\n" + //
                "LEFT JOIN\n" + //
                "    Branch_details hd ON r.Hotel_id = hd.Hotel_id\n" + //
                "LEFT JOIN\n" + //
                "    Room_types rt ON r.Room_id = rt.Room_id\n" + //
                "WHERE\n" + //
                "\thd.Hotel_city = ?;";
        return Query;
    }
}
