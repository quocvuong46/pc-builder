package com.pcbuilder.database;

import com.pcbuilder.models.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * ComponentDAO - Data Access Object để thao tác với database
 */
public class ComponentDAO {
    private DatabaseManager dbManager;

    public ComponentDAO() {
        this.dbManager = DatabaseManager.getInstance();
    }

    // ===== CPU Methods =====
    public List<CPU> getAllCPUs() {
        List<CPU> cpus = new ArrayList<>();
        String sql = "SELECT * FROM cpu";

        try (Statement stmt = dbManager.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                CPU cpu = new CPU(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("manufacturer"),
                    rs.getDouble("price"),
                    rs.getString("specifications"),
                    rs.getString("socket"),
                    rs.getInt("cores"),
                    rs.getString("base_clock")
                );
                cpus.add(cpu);
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi lấy danh sách CPU: " + e.getMessage());
        }
        return cpus;
    }

    // ===== Mainboard Methods =====
    public List<Mainboard> getAllMainboards() {
        List<Mainboard> mainboards = new ArrayList<>();
        String sql = "SELECT * FROM mainboard";

        try (Statement stmt = dbManager.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Mainboard mb = new Mainboard(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("manufacturer"),
                    rs.getDouble("price"),
                    rs.getString("specifications"),
                    rs.getString("socket"),
                    rs.getString("chipset"),
                    rs.getString("form_factor"),
                    rs.getInt("max_ram")
                );
                mainboards.add(mb);
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi lấy danh sách Mainboard: " + e.getMessage());
        }
        return mainboards;
    }

    // ===== RAM Methods =====
    public List<RAM> getAllRAMs() {
        List<RAM> rams = new ArrayList<>();
        String sql = "SELECT * FROM ram";

        try (Statement stmt = dbManager.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                RAM ram = new RAM(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("manufacturer"),
                    rs.getDouble("price"),
                    rs.getString("specifications"),
                    rs.getString("type"),
                    rs.getInt("capacity"),
                    rs.getString("speed")
                );
                rams.add(ram);
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi lấy danh sách RAM: " + e.getMessage());
        }
        return rams;
    }

    // ===== VGA Methods =====
    public List<VGA> getAllVGAs() {
        List<VGA> vgas = new ArrayList<>();
        String sql = "SELECT * FROM vga";

        try (Statement stmt = dbManager.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                VGA vga = new VGA(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("manufacturer"),
                    rs.getDouble("price"),
                    rs.getString("specifications"),
                    rs.getString("chipset"),
                    rs.getInt("vram"),
                    rs.getString("memory_type")
                );
                vgas.add(vga);
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi lấy danh sách VGA: " + e.getMessage());
        }
        return vgas;
    }

    // ===== Storage Methods =====
    public List<Storage> getAllStorages() {
        List<Storage> storages = new ArrayList<>();
        String sql = "SELECT * FROM storage";

        try (Statement stmt = dbManager.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Storage storage = new Storage(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("manufacturer"),
                    rs.getDouble("price"),
                    rs.getString("specifications"),
                    rs.getString("type"),
                    rs.getInt("capacity"),
                    rs.getString("read_speed"),
                    rs.getString("write_speed")
                );
                storages.add(storage);
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi lấy danh sách Storage: " + e.getMessage());
        }
        return storages;
    }

    // ===== PSU Methods =====
    public List<PSU> getAllPSUs() {
        List<PSU> psus = new ArrayList<>();
        String sql = "SELECT * FROM psu";

        try (Statement stmt = dbManager.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                PSU psu = new PSU(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("manufacturer"),
                    rs.getDouble("price"),
                    rs.getString("specifications"),
                    rs.getInt("wattage"),
                    rs.getString("efficiency"),
                    rs.getBoolean("modular")
                );
                psus.add(psu);
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi lấy danh sách PSU: " + e.getMessage());
        }
        return psus;
    }

    // ===== Case Methods =====
    public List<Case> getAllCases() {
        List<Case> cases = new ArrayList<>();
        String sql = "SELECT * FROM pc_case";

        try (Statement stmt = dbManager.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Case pcCase = new Case(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("manufacturer"),
                    rs.getDouble("price"),
                    rs.getString("specifications"),
                    rs.getString("form_factor"),
                    rs.getString("color"),
                    rs.getBoolean("has_rgb")
                );
                cases.add(pcCase);
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi lấy danh sách Case: " + e.getMessage());
        }
        return cases;
    }

    // ===== Cooler Methods =====
    public List<Cooler> getAllCoolers() {
        List<Cooler> coolers = new ArrayList<>();
        String sql = "SELECT * FROM cooler";

        try (Statement stmt = dbManager.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Cooler cooler = new Cooler(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("manufacturer"),
                    rs.getDouble("price"),
                    rs.getString("specifications"),
                    rs.getString("type"),
                    rs.getString("socket"),
                    rs.getInt("fan_size")
                );
                coolers.add(cooler);
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi lấy danh sách Cooler: " + e.getMessage());
        }
        return coolers;
    }
}
