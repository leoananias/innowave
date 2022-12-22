package  com.innowave.challenge.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@NamedQuery(name = "Program.findByChannelId", query = "select p from Program p where p.channel.id = ?1")
@NamedQuery(name = "Program.findByIdString", query = "select p from Program p where p.id = ?1")
public class Program implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	private String description;

	@Column(name="END_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date endTime;

	private String imageurl;

	@Column(name="START_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startTime;

	private String title;
	@ManyToOne
	@JoinColumn(name="CHANNEL_ID", nullable=false)
	private Channel channel;

	public Program(String description, Date endTime, String imageurl, Date startTime, String title, Channel channel) {
		this.description = description;
		this.endTime = endTime;
		this.imageurl = imageurl;
		this.startTime = startTime;
		this.title = title;
		this.channel = channel;
	}
}