import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import tr.gov.nvi.tckimlik.WS.KPSPublic;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MernisKimlikDogrulaUI {

	private JFrame frame;
	private JTextField txt_tc_no;
	private JTextField txt_ad;
	private JTextField txt_soyad;
	private JTextField txt_dogum_yili;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MernisKimlikDogrulaUI window = new MernisKimlikDogrulaUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MernisKimlikDogrulaUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 370, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbl_tc_no = new JLabel("Tc No");
		lbl_tc_no.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_tc_no.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_tc_no.setBounds(65, 74, 46, 14);
		frame.getContentPane().add(lbl_tc_no);
		
		JLabel lbl_ad = new JLabel("Ad");
		lbl_ad.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_ad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_ad.setBounds(65, 99, 46, 14);
		frame.getContentPane().add(lbl_ad);
		
		JLabel lbl_soyad = new JLabel("Soyad");
		lbl_soyad.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_soyad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_soyad.setBounds(65, 124, 46, 14);
		frame.getContentPane().add(lbl_soyad);
		
		JLabel lbl_dogum_yili = new JLabel("Doðum Yýlý");
		lbl_dogum_yili.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_dogum_yili.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_dogum_yili.setBounds(38, 149, 73, 14);
		frame.getContentPane().add(lbl_dogum_yili);
		
		txt_tc_no = new JTextField();
		txt_tc_no.setBounds(134, 73, 156, 20);
		frame.getContentPane().add(txt_tc_no);
		txt_tc_no.setColumns(10);
		
		txt_ad = new JTextField();
		txt_ad.setColumns(10);
		txt_ad.setBounds(134, 98, 156, 20);
		frame.getContentPane().add(txt_ad);
		
		txt_soyad = new JTextField();
		txt_soyad.setColumns(10);
		txt_soyad.setBounds(134, 123, 156, 20);
		frame.getContentPane().add(txt_soyad);
		
		txt_dogum_yili = new JTextField();
		txt_dogum_yili.setColumns(10);
		txt_dogum_yili.setBounds(134, 148, 156, 20);
		frame.getContentPane().add(txt_dogum_yili);
		
		JLabel lblNewLabel = new JLabel("Mernis Kimlik No Doðrula");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(78, 27, 226, 20);
		frame.getContentPane().add(lblNewLabel);
		
		//Button Action
		JButton btnNewButton = new JButton("Doðrula");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long tcNo = Long.parseLong(txt_tc_no.getText());
				String ad = txt_ad.getText();
				String soyad = txt_soyad.getText();
				int dogumYili = Integer.parseInt(txt_dogum_yili.getText());
				boolean result = false;
				
				try {
					
					KPSPublicSoapProxy kpsPublic = new KPSPublicSoapProxy();
					result = kpsPublic.TCKimlikNoDogrula(tcNo, ad, soyad, dogumYili);
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				if(result) {
					JOptionPane.showMessageDialog(null, "Kiþi Bulundu!");
				}else {
					JOptionPane.showMessageDialog(null, "Kiþi Bulunamadý!");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(125, 197, 119, 34);
		frame.getContentPane().add(btnNewButton);
	}
}
